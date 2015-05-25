inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ci20:"

COMPATIBLE_MACHINE = "ci20"

LINUX_VERSION = "3.18.13"

KBRANCH = "ci20-3.18.y"

SRC_URI = "git://github.com/akuster/linux-stable.git;bareclone=1;branch=${KBRANCH}"

SRCREV = "198345f0a6b951358699098d19bd9c0554102024"
PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI += "file://0001-jz4740-fix-irq-issue.patch \
            file://0001-brcm-add-firmware-for-sdio-card.patch \
            file://defconfig"

do_configure_preappend () {
    install -d ${S}/firmware/brcm
    cp ${WORKDIR}/defconfig ${B}/.config
}
