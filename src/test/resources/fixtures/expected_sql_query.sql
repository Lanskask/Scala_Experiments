select ORD_SHIPT_NBR,
     CONTNR_SCM_NBR,
     BSC_FRGT_CHRG_AMT,
     CONTNR_GRO_WT_QTY,
     CONTNR_GRO_WT_UOM_TXT,
     case
        when TRKG_NBR = '' then NULL
        when lower(TRKG_NBR) = 'null' then NULL
        else TRKG_NBR
     end as TRKG_NBR,
     INS_RUN_ID,
     UPD_RUN_ID,
     EFF_DTE,
     EXP_DTE
from   EIV_SHIPT_CONTNR
where  EFF_DTE <= '01-02-2019'
       AND EFF_DTE >= '02-02-2019'