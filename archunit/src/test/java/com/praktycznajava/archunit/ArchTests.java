package com.praktycznajava.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class ArchTests {

    @Test
    public void test1()
    {
        JavaClasses jc = new ClassFileImporter().importPackages("com.praktycznajava.archunit");

        ArchRule r1 = classes()
                .that()
                .resideInAPackage("..service..")
                .should()
                .onlyHaveDependentClassesThat()
                .resideInAPackage("..controller..");
        r1.check(jc);
    }

    @Test
    public void test2()
    {
        JavaClasses jc = new ClassFileImporter().importPackages("com.praktycznajava.archunit");

        Architectures.LayeredArchitecture arch = layeredArchitecture()
                // Definicja warst
                .layer("Presentation").definedBy("..controller..")
                .layer("Service").definedBy("..service..")
                .layer("Repository").definedBy("..repo..")
                // Dodawanie reguł
                .whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Presentation")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");
        arch.check(jc);
    }
}

