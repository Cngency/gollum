package org.gollum.common.domain;

/**
 * 值类型抽象
 *
 * @author wurenhai
 * @date 2017/12/26
 */
public abstract class ValueObject {

    protected abstract Object[] getAttributes();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (Object obj : getAttributes()) {
            result = result * prime + (obj == null ? 0 : obj.hashCode());
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return hashCode() == obj.hashCode();
        }
        return false;
    }
}