package NFI.Expolog.Eco_Obra.enums;

import NFI.Expolog.Eco_Obra.exceptions.CantGetEnumType;

public enum EstadoVenda {
    EM_ABERTO("em_aberto"),
    EM_PROCESSO("em_processo"),
    VENDIDO("vendido");

    private String estadoVendaEcoObra;

    EstadoVenda(String tipoVendaEcoObra){
        this.estadoVendaEcoObra = tipoVendaEcoObra;
    }

    public static EstadoVenda fromString(String valor){
        for (EstadoVenda estadoVenda : EstadoVenda.values()){
            if(estadoVenda.estadoVendaEcoObra.equals(valor)){
                return estadoVenda;
            }
        }
        throw new CantGetEnumType("cant return a " + TipoMaterial.class);
    }
}
