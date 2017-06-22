package models;
import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
@Table(name="aptitud")
public class TRep4 extends Model{
	@Id
	public Long id;
    public Integer ano;
	public String carrera_origen;
	public String carrera_solicitada;    
	public String alumno;
	public String carne;

	public static Finder<Long, TRep4> find = new Finder<Long,TRep4>(TRep4.class);
} 