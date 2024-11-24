package NFI.Expolog.Eco_Obra.enums;

import NFI.Expolog.Eco_Obra.exceptions.CantGetEnumType;

public enum TipoMaterial {
    NOVO("novo"),
    SEMI_NOVO("semi_novo"),
    USADO("usado");

    private String tipoEcoObra;

    TipoMaterial(String tipoEcoObra){
        this.tipoEcoObra = tipoEcoObra;
    }

    public static TipoMaterial fromString(String valor){
        for (TipoMaterial tipoMaterial : TipoMaterial.values()){
            if(tipoMaterial.tipoEcoObra.equals(valor)){
                return tipoMaterial;
            }
        }
        throw new CantGetEnumType("cant return a " + TipoMaterial.class);
    }
}
