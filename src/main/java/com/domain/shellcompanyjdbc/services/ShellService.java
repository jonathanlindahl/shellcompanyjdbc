package com.domain.shellcompanyjdbc.services;

import com.domain.shellcompanyjdbc.models.Shell;
import com.domain.shellcompanyjdbc.repositories.ShellRepository;

import java.util.List;

public class ShellService
{
    private final ShellRepository repository = new ShellRepository();
    
    public List<Shell> getShells()
    {
        return repository.getShells();
    }
    
    public List<Shell> getByModel(String model)
    {
        return repository.getByModel(model);
    }
    
    public Shell addShell(Shell shell)
    {
        return repository.addShell(shell);
    }
}
