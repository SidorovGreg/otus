package io.sidorovgreg.otus;

import java.util.Collection;

public interface Task {

    String execute(Collection<String> args);
}