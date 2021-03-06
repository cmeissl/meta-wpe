# Copyright (C) 2018 Khem Raj <raj.khem@gmail.com>, Wouter-lucas van Boesschoten <wouter@wouterlucas.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "WPE Framework image for rpi"
LICENSE = "MIT"

include recipes-core/images/core-image-minimal.bb

inherit distro_features_check

DISTRO_FEATURES_remove = "wayland"

IMAGE_FEATURES_remove = "splash"

IMAGE_FEATURES += "hwcodecs \
                   package-management \
                   ssh-server-dropbear \
"

# If WPE Framework is enabled as distro feature, remove the default packagegroup-core-boot and run with our own
IMAGE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'wpeframework', 'packagegroup-wpe-boot', '', d)} \
				  packagegroup-wpeframework \
				  packagegroup-wpe \
"

IMAGE_INSTALL_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'wpeframework', 'packagegroup-core-boot', '', d)}"
