*Dual JK FLIP FLOP - type:digital pkg:DIP16 [DVCC=16;DGND=8;](4,5,1,2,3,6,7,12,11,15,14,13,10,9)
.MODEL A74LS109 xsimcode(file="{MODEL_PATH}LS.SCB" func=ls109ax2 {mntymx})

*FAST Dual JK POS EDGE TRIG FLIP FLOP - type:digital pkg:DIP16 [DVCC=16;DGND=8;](A:5 2 4 3 1 7 6)(B:11 14 12 13 15 9 10)
.MODEL A74F109 xsimcode(file="{MODEL_PATH}FAST.SCB" func=f109x2 {mntymx})
