inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ci20:"

COMPATIBLE_MACHINE = "ci20"

LINUX_VERSION = "3.18.3"
BRANCH = "ci20-v3.18"

SRC_URI = "git://github.com/MIPS/CI20_linux.git;bareclone=1;branch=${BRANCH}"
SRCREV = "8ef5089c1baf62db99f0855d49bd2fb9b89be685"

KBRANCH = "linux-3.18.y"

#SRC_URI = "git://github.com/torvalds/linux.git;bareclone=1;branch=${KBRANCH}"
#SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;bareclone=1;branch=${KBRANCH}"
#SRCREV = "72d391fefcd4729206d2e17f557e7a918de9b6d8"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI += "file://0001-jz4740-fix-irq-issue.patch \
            file://0001-brcm-add-firmware-for-sdio-card.patch \
            file://defconfig"

do_configure_preappend () {
    install -d ${S}/firmware/brcm
    cp ${WORKDIR}/defconfig ${B}/.config
}
