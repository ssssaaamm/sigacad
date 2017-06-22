package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="bajoRendimiento")
public class TRep1 extends Model{
	@Id
	public Long id;
	public String carrera;
	public Integer ano;
	public String alumno;
	public String carne;
	public Double mediaCiclo;
	public Double cum;

	public static Finder<Long, TRep1> find = new Finder<Long,TRep1>(TRep1.class);
} 