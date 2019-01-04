SUMMARY = "Firmware for the REFLEX CES Alaric FPGA"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit deploy

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCREV_FORMAT = "hardware"
SRCREV_hardware = "${AUTOREV}"

PV="${PN}+git${SRCPV}"

SRC_URI += " \
   git://github.com/dnegvesky/alaric-hardware.git;destsuffix=hardware;name=hardware;protocol=https;branch=master \
"

do_install () {
        cd ${WORKDIR}/hardware
        install -d ${D}${base_libdir}/firmware
        install -m 0644 output_files/alaric.rbf ${D}${base_libdir}/firmware
        install -m 0644 devicetrees/alaric.dtbo ${D}${base_libdir}/firmware
}

do_deploy () {
        cd ${WORKDIR}/hardware
        install -d ${DEPLOYDIR}
        install -m 0644 output_files/alaric.rbf ${DEPLOYDIR}
}

addtask deploy after do_install

FILES_${PN} = "${base_libdir}/firmware"
