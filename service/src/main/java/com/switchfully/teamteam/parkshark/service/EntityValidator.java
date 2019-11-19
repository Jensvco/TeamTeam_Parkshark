package com.switchfully.teamteam.parkshark.service;

public abstract class EntityValidator<T> {

    public boolean isValidForCreation(T entity) {
        return !isAFieldEmptyOrNull(entity);
    }

    protected abstract boolean isAFieldEmptyOrNull(T entity);

    protected boolean isEmptyOrNull(String attribute) {
        return attribute == null || attribute.isEmpty();
    }

    protected boolean isNull(Object object) {
        return object == null;
    }

}
