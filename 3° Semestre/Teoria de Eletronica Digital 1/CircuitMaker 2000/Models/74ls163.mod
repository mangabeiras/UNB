*LS 4-bit binary counter - type:digital pkg:DIP16 [DVCC=16;DGND=8;](7,10,2,9,6,5,4,3,1,15,11,12,13,14)
.MODEL A74LS163A xsimcode(file="{MODEL_PATH}LS.SCB" func=ls163 {mntymx})

*FAST 4-bit binary counter - type:digital pkg:DIP16 [DVCC=16;DGND=8;](7,10,2,9,6,5,4,3,1,15,11,12,13,14)
.MODEL A74F163A xsimcode(file="{MODEL_PATH}FAST.SCB" func=f163 {mntymx})
