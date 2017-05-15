package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import java.util.*;
import java.io.File;

import views.html.administrador.*;
import models.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class AdministradorController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result home() {
        return ok(welcome.render());
    }

    //USUARIOS
    //list
    public Result usuarios() {



        /*validacion de usuario logeado*/
        // String connected = session("username");
        
        // if(connected == null){
        //    return redirect(routes.HomeController.login());
        // }else{
        //     Usuario u = Usuario.find.where().eq("username",connected).findUnique();
        //     if(u==null){
        //         return redirect(routes.HomeController.login());         
        //     }else{
        //         if( !u.tipo.codigo.equals( 2 )){

        //             flash("error","Permisos denegados para el usuario");

        //             if(u.tipo.codigo.intValue()==1){
        //                 return badRequest(views.html.administrador.errores.render());
        //             }else{
        //                 if(u.tipo.codigo.intValue()==2){
        //                     return badRequest(views.html.gerente.errores.render());
        //                 }else{
        //                     return badRequest(views.html.logistica.errores.render());
        //                 }
        //             }                    
        //         }
        //     }
        // } 
        /*validacion de usuario logeado*/



        Form<Usuario> usuario_form = Form.form(Usuario.class);
        List<Usuario> usuarios_list = Usuario.find.findList();
        return ok(usuarios.render(usuario_form,usuarios_list));
    }

    //add
    public Result usuario_new() {



        /*validacion de usuario logeado*/
        // String connected = session("username");
        
        // if(connected == null){
        //    return redirect(routes.HomeController.login());
        // }else{
        //     Usuario u = Usuario.find.where().eq("username",connected).findUnique();
        //     if(u==null){
        //         return redirect(routes.HomeController.login());         
        //     }else{
        //         if( !u.tipo.codigo.equals( 2 )){

        //             flash("error","Permisos denegados para el usuario");

        //             if(u.tipo.codigo.intValue()==1){
        //                 return badRequest(views.html.administrador.errores.render());
        //             }else{
        //                 if(u.tipo.codigo.intValue()==2){
        //                     return badRequest(views.html.gerente.errores.render());
        //                 }else{
        //                     return badRequest(views.html.logistica.errores.render());
        //                 }
        //             }                    
        //         }
        //     }
        // } 
        /*validacion de usuario logeado*/



        Form<Usuario> usuario_form = Form.form(Usuario.class).bindFromRequest();
        Map<String, String[]> values = request().body().asFormUrlEncoded();
        List<Usuario> usuarios_list = Usuario.find.findList();

        //Si hay errores siempre los retornara
        if( usuario_form.hasErrors() ){
            flash("modal","mod-new");
            return badRequest(usuarios.render(usuario_form,usuarios_list));
        }
        if( Usuario.find.where().eq("username",values.get("username")[0]).findUnique()!=null){
            flash("error","El usuario ya existe");
            flash("modal","mod-new");
            return redirect(routes.AdministradorController.usuarios());
        }

        Usuario nuevo = usuario_form.get();
        nuevo.save();

        flash("exito","Operacion exitosa!");

        return redirect(routes.AdministradorController.usuarios());
    }

    //edit
    public Result usuario_edit(Long id) {



        /*validacion de usuario logeado*/
        // String connected = session("username");
        
        // if(connected == null){
        //    return redirect(routes.HomeController.login());
        // }else{
        //     Usuario u = Usuario.find.where().eq("username",connected).findUnique();
        //     if(u==null){
        //         return redirect(routes.HomeController.login());         
        //     }else{
        //         if( !u.tipo.codigo.equals( 2 )){

        //             flash("error","Permisos denegados para el usuario");

        //             if(u.tipo.codigo.intValue()==1){
        //                 return badRequest(views.html.administrador.errores.render());
        //             }else{
        //                 if(u.tipo.codigo.intValue()==2){
        //                     return badRequest(views.html.gerente.errores.render());
        //                 }else{
        //                     return badRequest(views.html.logistica.errores.render());
        //                 }
        //             }                    
        //         }
        //     }
        // } 
        /*validacion de usuario logeado*/



        Form<Usuario> usuario_form = Form.form(Usuario.class).bindFromRequest();
        List<Usuario> usuarios_list = Usuario.find.findList();

        //Si hay errores siempre los retornara
        if( usuario_form.hasErrors() ){
            flash("modal","mod-edit-"+id.toString());
            return badRequest(usuarios.render(usuario_form,usuarios_list));
        }

        Usuario user = Usuario.find.byId(id);

        if ( user != null) {
            user.nombre=usuario_form.get().nombre;
            
            
            user.username=usuario_form.get().username;
            user.password=usuario_form.get().password;
            user.tipo.id=usuario_form.get().tipo.id;

            user.update();
        }        

        flash("exito","Operacion exitosa!");

        return redirect(routes.AdministradorController.usuarios());
    }
    //remove
    public Result usuario_remove(Long id){



        /*validacion de usuario logeado*/
        // String connected = session("username");
        
        // if(connected == null){
        //    return redirect(routes.HomeController.login());
        // }else{
        //     Usuario u = Usuario.find.where().eq("username",connected).findUnique();
        //     if(u==null){
        //         return redirect(routes.HomeController.login());         
        //     }else{
        //         if( !u.tipo.codigo.equals( 2 )){

        //             flash("error","Permisos denegados para el usuario");

        //             if(u.tipo.codigo.intValue()==1){
        //                 return badRequest(views.html.administrador.errores.render());
        //             }else{
        //                 if(u.tipo.codigo.intValue()==2){
        //                     return badRequest(views.html.gerente.errores.render());
        //                 }else{
        //                     return badRequest(views.html.logistica.errores.render());
        //                 }
        //             }                    
        //         }
        //     }
        // } 
        /*validacion de usuario logeado*/
        

        
        Usuario user = Usuario.find.byId(id);
        if(user != null){
            user.delete();
            flash("exito","Operacion exitosa!");
            return redirect(routes.AdministradorController.usuarios());
        }
        return redirect(routes.AdministradorController.usuarios());
    }

}
