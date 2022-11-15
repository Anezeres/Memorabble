
import java.time.Duration;
import java.time.Instant;



/**
 *
 * @author evalab
 */
public class Jugador{
    
    private String nombre;
    private int vidas;
    private int puntos;
    private Instant startTime;
    private Instant endTime;
    private Duration finalPartidaTime;
    private int minutos;
    private int segundos;

    public Jugador() {
    }
    
    public void comezarTiempo(){
        startTime = Instant.now();
    }
    
    public void terminarTiempo(){
        endTime = Instant.now();
    }
    
    public void calcularTiempo(){
        finalPartidaTime = Duration.between(startTime,endTime);
        asignarTiempo();
    }
    
    /* Getters and Setters */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void asignarTiempo() {
        segundos = (int) finalPartidaTime.getSeconds();
        segundos %= 3600;
        if(segundos > 60){
            minutos = (int) (segundos / 60);
            segundos %= 60;
        }else{
            segundos = (int) finalPartidaTime.getSeconds();
        }  
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getSegundos() {
        String segundosTexto;
        if(segundos<10){
            segundosTexto = "0" + segundos;
        }else{
            segundosTexto = String.valueOf(segundos);
        }
        return segundosTexto;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

  
}
