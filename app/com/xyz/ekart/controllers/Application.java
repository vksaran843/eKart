package com.xyz.ekart.controllers;

import play.mvc.*;

public class Application extends Controller {
  
  public  Result index() {
    return ok("Your new application is ready.");
  }
  
}
