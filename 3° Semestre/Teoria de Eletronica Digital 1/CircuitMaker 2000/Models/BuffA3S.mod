*LS Quad 3-state buffer - type:digital pkg:DIP14 [DVCC=14;DGND=7;](A:2,1,3)(B:5,4,6)(C:9,10,8)(D:12,13,11)
.MODEL A74LS125 xsimcode(file="{MODEL_PATH}LS.SCB" func=buffa3s {mntymx})

*FAST Quad 3-state buffer - type:digital pkg:DIP14 [DVCC=14;DGND=7;](A:2,1,3)(B:5,4,6)(C:9,10,8)(D:12,13,11)
.MODEL A74F125 xsimcode(file="{MODEL_PATH}FAST.SCB" func=f125 {mntymx})
