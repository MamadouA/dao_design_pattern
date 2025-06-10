package org.mnjaay.dao.impl;

import org.mnjaay.entities.Note;

public class HibernateNoteDaoImpl extends HibernateObjectDaoImpl<Note> {
    public HibernateNoteDaoImpl() {
        super(Note.class);
    }
}
