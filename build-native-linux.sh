#!/bin/bash
set -e
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

# buildDocker( GOOS GOARCH )
buildDocker() {
    local BUILD_DIR="$DIR/build"
    local SRC_DIR="$DIR"

    rm -rf "$BUILD_DIR"
    mkdir "$BUILD_DIR"
    cat >"$BUILD_DIR/run.sh" <<EOF
#!/bin/bash
set -e

echo "Updating packages..."
apt-get update -y
apt-get install -y build-essential gcc-multilib

echo "Building native libs of pty4j-bashsupport ..."
cd /src
cd native
make -f Makefile_linux clean all
echo Successfully built pty4j-bashsupport...
echo
EOF
  chmod u+x "$BUILD_DIR/run.sh"

    docker run --rm -t \
        --mount "src=$BUILD_DIR,target=/build,type=bind" \
        --mount "src=$SRC_DIR,target=/src,type=bind" \
        ubuntu:xenial /build/run.sh

    rm -rf "$BUILD_DIR"
}

cd "$DIR"
buildDocker
