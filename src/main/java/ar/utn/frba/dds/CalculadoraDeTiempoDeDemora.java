package ar.utn.frba.dds;

public class CalculadoraDeTiempoDeDemora {
    public Integer calcularTiempoDeDemoraAproximadoEnMinutos(CalculadoraDeDistancia calculadoraDeDistancia, List<Destino> paradas){
        Double distanciaEnKMTotal = 0.0;
        Integer tiempoDetenidoEnMinutos = 0;

        for(int i=0;i<paradas.size()-1;i++){
            Destino destinoInicial = paradas.get(i);
            Destino destinoFinal = paradas.get(i+1);
            distanciaEnKMTotal += calculadoraDeDistancia.calcularDistanciaEnKMEntre(destinoInicial,destinoFinal);
            if(destinoInicial.cantidadMinutosADetenerse()>0){
                tiempoDetenidoEnMinutos += destinoInicial.cantidadMinutosADetenerse();
            }
        }

        Integer velocidadPromedioEnKMPorHora = 4;
        Double tiempoTotalEnHoras = distanciaEnKMTotal/velocidadPromedioEnKMPorHora;
        Integer tiempoTotalEnMinutos = (int) (tiempoTotalEnHoras*60); //convertimos horas a minutos
        tiempoTotalEnMinutos += tiempoDetenidoEnMinutos;

        return tiempoTotalEnMinutos;
    }
}
