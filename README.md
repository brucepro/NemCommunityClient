This build will accomplish the following: 
continue using ncc wallet and storage functions on current start page and login. 
migrate all webapp functions to nanowallet features

determine which api calls can be depreciated. 


NEM Community Client (NCC)
====================
[![Build Status](https://travis-ci.org/NemProject/NemCommunityClient.svg?branch=master)](https://travis-ci.org/NemProject/NemCommunityClient)

NCC is the initial client provided with NEM. It provides a web interface for managing wallets and interacting with the NEM Infrastructure Server (NIS).

NCC Packages
------------

There are two NCC maven packages:

- nem-client-api: Contains all NCC functionality as well as the web UX.
- nem-monitor: Monitors NCC and local NIS, provides visual feedback on actual status of those apps.

There two more packages
- nem-client-download: Used by WebStart to download NCC and NIS. (deprecated, switched to installer version)
- nem-console: A command-line tool providing utility functionality.

Building
--------

nem.core is required to build NCC. Most recent version, can be found [here](http://bob.nem.ninja)
nem.core documentation can be found [here](http://bob.nem.ninja/org.nem.core/)

Running NCC Locally
-------------------

In order to run the client with full functionality, a NEM Infrastructure Server (NIS) instance should be running
on the local machine.

The NCC client can be started by running the org.nem.deploy.CommonStarter class.

The monitor programm is started via org.nem.monitor.NemMonitor

NCC REST API
------------

The NCC API is available as a swagger.json file [here](docs/ncc-api-swagger.json).

A rendered version is available [here](http://nem.pucchiwerk.eu/ncc/api/).

(The deprecated version of the NCC REST API can be found [here](docs/api.md)).

Generating JavaDoc Documentation
--------------------------------
The javadoc documentation can be created via the maven goal "javadoc:javadoc" on the project "nem-client-api".

Pull Requests
-------------

NCC is fully open-sourced and looking for contributors. Please take a fork and add a feature :).

The NEM core development team will be managing pull requests into master.
Please try to follow the guidelines outlined [here](http://www.booleanknot.com/blog/2013/09/07/pull-requests.html).

Coding Guidelines
-----------------

Please use the intellij settings checked in under settings/nem_project_settings.jar. A non-comprehensive list of style guidelines follow, but the checked in settings should take precedence.  

### Member Naming
- Use lowerCamelCase.
- Prefix booleans with "is" / "has" / "are".
- Precede access of instance members with "this.".
- Camel case acronyms at least three letters (i.e. prefer "Nis" to "NIS").

### Braces
- Always use braces (even for single line statement bodies).
- Follow '}' with a blank line.
- Do not precede '}' with a blank line.

### Imports
- Wildcard import package if more than one class is used from a package.
- Sort imports alphabetically.

### Documentation
- Document all public and protected members.
- Getter documentation should start with "Gets".
- All documentation should start with capital letter and end with period (for members documentation too).

### Unit Tests
- Try to avoid testing composite classes.
- Use Act / Arrange / Assert.

### Other
- Use the final keyword aggressively.
- Avoid the use of trailing whitespace.
- Keep functions short and understandable :).
- Do not introduce consecutive blank lines.
