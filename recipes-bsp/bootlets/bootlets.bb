DESCRIPTION = "Arndale u-boot images" 
SECTION = "bootloaders"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "file://u-boot-spl.bin \
           file://u-boot.img \
           file://boot.ini"

inherit deploy

do_configure[noexec] = "1"

S = "${WORKDIR}"

do_deploy () {
    install -m 755 ${S}/u-boot-spl.bin ${DEPLOYDIR}
    install -m 755 ${S}/u-boot.img ${DEPLOYDIR}
    install -m 755 ${S}/boot.ini ${DEPLOYDIR}
}

addtask deploy before do_build after do_compile

PACKAGE_ARCH = "${MACHINE_ARCH}"
