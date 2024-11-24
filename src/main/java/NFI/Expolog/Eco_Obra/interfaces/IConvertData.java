package NFI.Expolog.Eco_Obra.interfaces;

public interface IConvertData {

    <T> T getData(String json,Class<T> tclass);
}
