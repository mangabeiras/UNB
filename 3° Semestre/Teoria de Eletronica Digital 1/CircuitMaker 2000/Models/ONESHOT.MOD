*Default - type:oneshot
.MODEL AONESHOT oneshot(
+ cntl_array=[0 1] 
+ pw_array=[1E-6 1E-4] )

*Test - type:oneshot
.MODEL ATEST oneshot(pos_edge_trig=TRUE 
+ cntl_array=[0 1] 
+ pw_array=[1e-006 0.0001] out_high=5 rise_delay=7.5E-5 retrig=FALSE )
