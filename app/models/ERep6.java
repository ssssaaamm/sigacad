package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="materiasRetiradas")
public class ERep6 extends Model{
	@Id
	public Long id;
	public String materia;
	public Integer retiros;

	public static Finder<Long, ERep6> find = new Finder<Long,ERep6>(ERep6.class);

} 