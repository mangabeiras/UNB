*LS Hex Inverter with hysteresis - type:digital pkg:DIP14 [DVCC=14;DGND=7;](A:1,2)(B:3,4)(C:5,6)(D:9,8)(E:11,10)(F:13,12)
.MODEL A74LS14 xsimcode(file="{MODEL_PATH}LS.SCB" func=ls14 {mntymx})

*FAST Hex Inverter with hysteresis - type:digital pkg:DIP14 [DVCC=14;DGND=7;](A:1,2)(B:3,4)(C:5,6)(D:9,8)(E:11,10)(F:13,12)
.MODEL A74F14 xsimcode(file="{MODEL_PATH}FAST.SCB" func=f14 {mntymx})
