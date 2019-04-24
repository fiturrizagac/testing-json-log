Para publicar snapshots

- Agregar en el archivo settings.xml

```xml
...
<server>
      <id>befitca-snapshots</id>
      <username>usuario</username>
      <password>contrasenia_hasheada</password>
</server>
...
```

- Ejecutar comando, solo para deployar snaphots
```bash
mvn clean deploy -DrepositoryId=befitca-snapshots
```
