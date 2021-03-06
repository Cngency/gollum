package org.gollum.core.commanding;

/**
 * @author wurenhai
 * @date 2018/1/2
 */
public interface CommandHandler<T extends Command> {

    void exec(T command);

}
