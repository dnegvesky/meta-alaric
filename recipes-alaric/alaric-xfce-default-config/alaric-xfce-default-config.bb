DESCRIPTION = "This recipe presets xfce user default configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r4"

inherit allarch

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
    file://.config \
    file://xfce-reflexces.jpg \
    "

do_install() {
    # default root user configration -> /home/root
    install -d ${D}/home/root
    cp -r ${WORKDIR}/.config ${D}/home/root
    
    # default new user configration -> /etc/skel
    install -d ${D}${sysconfdir}/skel
    cp -r ${WORKDIR}/.config ${D}${sysconfdir}/skel/

    # background
    install -d ${D}${datadir}/backgrounds/xfce
    install -m 0644 ${WORKDIR}/xfce-reflexces.jpg ${D}${datadir}/backgrounds/xfce
}

FILES_${PN} += "${datadir}/backgrounds/xfce /home/root"
