package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import java.util.*;
import java.io.File;

import views.html.*;
import models.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result home() {
        //return ok("comun works!");
        return redirect(routes.HomeController.login());
    }


    public Result login() {
        return ok(login.render());
    }


    public Result login_post() {
        Map<String, String[]> values = request().body().asFormUrlEncoded();

        String username=values.get("username")[0];
        String password=values.get("password")[0];


        Usuario u = Usuario.find.where().eq("username",username).findUnique();

        if(u ==null ){
            flash("no_registered","Usuario '"+username+"' no registrado");
            return redirect(routes.HomeController.login());
        }else{
            
            if( u.password.equals(password) ){
                //return ok("empleado registrado y password concuerda");
                if(u.tipo.codigo == 1){
                    session("username",username);
                    return redirect(routes.AdministradorController.home());
                }

                if(u.tipo.codigo == 2){
                    session("username",username);
                    return redirect(routes.EstrategicoController.home());
                }

                if(u.tipo.codigo == 3){
                    session("username",username);
                    return redirect(routes.TacticoController.home());
                }

            }else{
                flash("no_password","Contraseña invalida");
                return redirect(routes.HomeController.login());
            }
            
        }

        return null;

    }

    public Result logout() {


        /*validacion de usuario logeado*/
        String username = session("username");
        
        if(username == null){
            return redirect(routes.HomeController.login());
        }
        /*validacion de usuario logeado*/


        session().clear();
        return redirect(routes.HomeController.login());
    }

}
