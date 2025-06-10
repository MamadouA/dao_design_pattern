package org.mnjaay.factory;

public class ConcreteFactory {

    public static AbstractFactory getFactory(Class<? extends AbstractFactory> typeFactory) {
        if(typeFactory == EtudiantFactory.class)
            return new EtudiantFactory();
        if(typeFactory == EnseignantFactory.class)
            return new EnseignantFactory();
        if(typeFactory == BulletinFactory.class)
            return new BulletinFactory();
        if(typeFactory == ModuleFactory.class)
            return new ModuleFactory();
        if(typeFactory == NoteFactory.class)
            return new NoteFactory();
        if(typeFactory == ReleveFactory.class)
            return new ReleveFactory();
        if(typeFactory == ClasseFactory.class)
            return new ClasseFactory();

        return null;
    }
}
