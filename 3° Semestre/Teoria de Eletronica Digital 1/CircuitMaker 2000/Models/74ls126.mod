*LS quad 3-state buffers  - type:digital pkg:DIP14 [DVCC=14;DGND=7;](13,12,10,9,4,5,1,2,11,8,6,3)
.MODEL A74LS126 xsimcode(file="{MODEL_PATH}LS.SCB" func=ls126x4 {mntymx})

*FAST quad 3-state buffers - type:digital pkg:DIP14 [DVCC=14;DGND=7;](13,12,10,9,4,5,1,2,11,8,6,3)
.MODEL A74F126 xsimcode(file="{MODEL_PATH}FAST.SCB" func=f126x4 {mntymx})
