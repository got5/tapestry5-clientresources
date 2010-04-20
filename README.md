# Tapestry 5 Client Resources Module

## How to

This module provides an override of ClientInfrastructure service in order to make it contribuable.
It also decorate RenderSupport in order to get rid off any Prototype specific declaration in generated pages.

## Maven dependency

To use this plugin, add the following dependency in your `pom.xml`.

	<dependencies>
		...
		<dependency>
			<groupId>org.got5</groupId>
			<artifactId>tapestry5-clientresources</artifactId>
			<version>1.0.2</version>
		</dependency>
		...
	</dependencies>
	
	<repositories>
		...
		<repository>
			<id>devlab722-repo</id>
			<url>http://nexus.devlab722.net/nexus/content/repositories/releases
			</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>

		<repository>
			<id>devlab722-snapshot-repo</id>
			<url>http://nexus.devlab722.net/nexus/content/repositories/snapshots
			</url>
			<releases>
				<enabled>false</enabled>
			</releases>
		</repository>
		
		...
	</repositories>

## More Informations & contacts

* Twitter: http://twitter.com/robinkomiwes


## License

This project is distributed under Apache 2 License. See LICENSE.txt for more information.
