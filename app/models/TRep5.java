package models;
import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
@Table(name="electiva")
public class TRep5 extends Model{
	@Id
	public Long id;
    public Integer ano;
	public String carrera;
	public Integer ciclo;    
	public String materia;
	public Integer poblacion;

	public static Finder<Long, TRep5> find = new Finder<Long,TRep5>(TRep5.class);
} 