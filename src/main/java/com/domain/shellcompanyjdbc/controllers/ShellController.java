package com.domain.shellcompanyjdbc.controllers;

import com.domain.shellcompanyjdbc.models.Shell;
import com.domain.shellcompanyjdbc.repositories.ShellRepository;
import com.domain.shellcompanyjdbc.services.ShellService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShellController
{
    ShellService service = new ShellService();
    
    @GetMapping("shell/allshells")
    public List<Shell> getShells()
    {
        return service.getShells();
    }
    
    @GetMapping("/shell/getbymodel")
    public List<Shell> getByModel(@RequestParam String model)
    {
        return service.getByModel(model);
    }
    
    @PostMapping("/shell/addshell")
    public Shell addShell(@RequestBody Shell newShell)
    {
        return service.addShell(newShell);
    }
}
