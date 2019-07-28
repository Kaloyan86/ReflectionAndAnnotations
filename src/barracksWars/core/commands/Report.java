package barracksWars.core.commands;

import barracksWars.anotations.Inject;
import barracksWars.interfaces.Repository;


public class Report extends Command {

    @Inject
    Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
