* Default Chebyshev lowpass filter with 3kHz corner frequency - type:sxfer
.MODEL ASXFER s_xfer(in_offset=0 gain=1
+ num_coeff=[1]
+ den_coeff=[1 1.42562 1.5162]
+ int_ic=[0 0 0] )


*test1 - type:sxfer
.MODEL ATEST1 s_xfer(denormalized_freq=5000 
+ num_coeff=[1 1] 
+ den_coeff=[1.4 1.5 1] 
+ int_ic=[0 0] )

*test2 - type:sxfer
.MODEL ATEST2 s_xfer(denormalized_freq=10000 
+ num_coeff=[1 1] 
+ den_coeff=[1.4 1.5 1] 
+ int_ic=[0 0] )
