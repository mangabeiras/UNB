* Default - type:hysteresis
.MODEL AHYSTERESIS hyst()


*Example - type:hysteresis
.MODEL ATEST1 hyst(in_low=0.8 in_high=2.2 hyst=0.5 fraction=TRUE )

*Example - type:hysteresis
.MODEL ATEST2 hyst(in_low=0.8 in_high=2.2 hyst=0.25 fraction=TRUE )
