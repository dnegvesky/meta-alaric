DESCRIPTION = "REFLEX CES Alaric Board Web Content"
AUTHOR = "Dan Negvesky <dnegvesky@reflexces.com>"
SECTION = "alaric"

LICENSE = "MIT & LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a8f924340e3ce1ff14c0f9f53b9a6da4"

PR = "r1"
SRCREV = "${AUTOREV}"
PV = "1.0${PR}+git${SRCPV}"

SRC_URI = "git://github.com/dnegvesky/alaric-webcontent.git"
S = "${WORKDIR}/git"

inherit allarch

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
