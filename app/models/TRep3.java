package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="pera")
public class TRep3 extends Model{
	@Id
	public Long id;
	public String carrera;
	public String alumno;
	public String carne;
	public Double cum;

	public static Finder<Long, TRep3> find = new Finder<Long,TRep3>(TRep3.class);
} 