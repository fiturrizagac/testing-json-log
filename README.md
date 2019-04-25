# Para manejar releases

#### Para publicar snapshots

- Agregar en el pom.xml

```xml
...
<distributionManagement>
    <snapshotRepository>
        <id>befitca-snapshots</id>
        <name>Befitca Snapshot Repository</name>
        <url>http://localhost/artifactory/befitca-development</url>
    </snapshotRepository>
</distributionManagement>
...

```

- Agregar en el archivo settings.xml

```xml
...
<servers>
    <server>
          <id>befitca-snapshots</id>
        <username><!-- usuario --></username>
        <password><!--contrasenia_hasheada --></password>
    </server>
</servers>    
...
```

- Ejecutar comando, solo para deployar snaphots
```bash
mvn clean deploy -DrepositoryId=befitca-snapshots
```

#### Para publicar releases


- Agregar en el pom.xml

```xml
...
<distributionManagement>
    ...
    <repository>
        <id>befitca-releases</id>
        <name>Befitca Release Repositoy</name>
        <url>http://localhost/artifactory/befitca</url>
    </repository>
    ...
</distributionManagement>

...

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-release-plugin</artifactId>
            <version>2.5.3</version>
        </plugin>
    </plugins>
</build>
...

```

- Agregar en el archivo settings.xml

```xml
<servers>
...
    <server>
        <id>befitca-releases</id>
        <username><!-- usuario --></username>
        <password><!--contrasenia_hasheada --></password>
    </server>
    <server>
        <id>github.com</id>
        <username><!-- usuario --></username>
        <password><!--contrasenia --></password>
    </server>
...    
</servers>
```
```

- Ejecutar comando, solo para deployar snaphots
```bash
 mvn release:prepare -B
 mvn release:perform -B
