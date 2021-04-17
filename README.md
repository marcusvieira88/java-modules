# Java Modules

Project used to study java modules

### Command to compile:
```
cd java-modules
javac -d outDir --module-source-path student-modules $(find student-modules -name "*.java")
```
### Command to run:
```
cd java-modules
java --module-path outDir -m client.module/tech.marcusvieira.student.client.Client  
```

## Requires

Now, my.module has both a runtime and a compile-time dependency on module.name.

```
module my.module {
    requires module.name;
}
```

## Requires Static

Sometimes we write code that references another module, but that users of our
 library will never want to use.

In these cases, we want to use an optional dependency. By using the requires 
static directive, we create a compile-time-only dependency:
```
module my.module {
    requires static module.name;
}
```

## Requires Transitive

we can use the requires transitive directive to force any downstream 
consumers also to read our required dependencies:
```
module my.module {
    requires transitive module.name;
}
```

## Exports

By default, a module doesn't expose any of its API to other modules. 
We use the exports directive to expose all public members of the named package:
```
module my.module {
    exports com.my.package.name;
}
```

## Exports … To

We can use exports…to to open up our public classes to the world.
We can restrict which modules have access to our APIs using the exports…to directive.
```
module my.module {
    export com.my.package.name to com.specific.package;
}
```

## Uses

We designate the services our module consumes with the uses directive.
Note that the class name we use is either the interface or abstract class of the service, 
not the implementation class:
```
module my.module {
    uses class.name;
}
```

## Provides … With

A module can also be a service provider that other modules can consume.
The first part of the directive is the provides keyword. Here is where we put the interface or abstract class name.

Next, we have the with directive where we provide the implementation class name that
 either implements the interface or extends the abstract class.

Here's what it looks like put together:
```
module my.module {
    provides MyInterface with MyInterfaceImpl;
}
```

## Open

Before Java 9, it was possible to use reflection to examine every type and 
member in a package, even the private ones. Nothing was truly encapsulated, which can 
open up all kinds of problems for developers of the libraries.we now have to explicitly 
grant permission for other modules to reflect on our classes.
```
open module my.module {
}
```

## Opens

we can use the opens directive to expose specific packages.
```
module my.module {
  opens com.my.package;
}
```


## Opens … To

We can selectively open our packages to a pre-approved list of modules, in this case, 
using the opens…to directive:
```
module my.module {
  opens com.my.package to moduleOne, moduleTwo, etc.;
}
```

## Command Line Options

- module-path – We use the –module-path option to specify the module path. This is a list of one or more directories that contain your modules.
- add-reads – Instead of relying on the module declaration file, we can use the command line equivalent of the requires directive; –add-reads.
- add-exports – Command line replacement for the exports directive.
- add-opens – Replace the open clause in the module declaration file.
- add-modules – Adds the list of modules into the default set of modules
- list-modules – Prints a list of all modules and their version strings
- patch-module – Add or override classes in a modules
- illegal-access=permit|warn|deny – Either relax strong encapsulation by showing a single global warning, shows every warning, or fails with errors. The default is permit.

### Reference 
[Java 9](https://www.oracle.com/corporate/features/understanding-java-9-modules.html)
[Baeldung](https://www.baeldung.com/java-9-modularity)