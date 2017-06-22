package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="egresados")
public class ERep4 extends Model{
	@Id
	public Long id;
	public String carrera;
	public Integer promocion;
	public Integer promedio;

	public static Finder<Long, ERep4> find = new Finder<Long,ERep4>(ERep4.class);

} 