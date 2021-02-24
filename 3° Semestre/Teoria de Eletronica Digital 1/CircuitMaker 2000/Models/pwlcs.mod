*Default - type:pwlcs
.MODEL APWL pwl(fraction=TRUE 
+ x_array=[-1 1] 
+ y_array=[-1 1] )

*test - type:pwlcs
.MODEL ATEST pwl(fraction=TRUE 
+ x_array=[-1 1] 
+ y_array=[-2 1] )
