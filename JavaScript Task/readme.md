# Angular

## <b>1. what is node, npm, nvm and yarn? How to use it.</b>

- Node :- &nbsp;&nbsp; It's used for traditional web sites and back-end API services, but was designed with real-time, push-based architectures in mind.

    > it is an open source, cross-platform runtime environment for developing server-side and networking applications.

- NPM:- `node Package Manager` it is manage your all the dependencies. npm is commandline tool which can insatll all the dependencies of a project.

    > - All dependencies are defined in `project.json` file.
    > - The goal of `package-lock.json` file is to keep track of the exact version of every package that is installed so that a product is 100% reproducible in the same way even if packages are updated by their maintainers.

- NVM :- nvm stands for `Node Version Manager` L it's provide locally download any of the remote Long Term Support (LTS) versions of Node.js with a simple command. Easily switch between multiple versions of Node.

- yarn :- Yarn is a package manager for your code. It allows you to use and share code with other developers from around the world. Yarn does this quickly, securely, and reliably. it developed by `facebook`.

> yarn is similar work as a `NPM`

> ### ***Diffreance between yarn and npm***
> - Major diffreance is package installation. Yarn installs packages in parallel. Yarn is optimized to fetch and install multiple packages at once. NPM will perform a serial installation process.

## <b>2. What is the Diffrenc between Angular 1,2,4</b>

- ### Angular 1 
    - Also known as Angular JS. an open-source, JavaScript-based, front-end web application framework for dynamic web app development.
    

- ### Angular 2
    - Components are directives with a template. They deal with a view of the application and logic on the page. There are two kinds of directives in Angular2.

> - major diiffrence between Angular 1 and angular 2 is Language. it means angular1(AngularJS) is written in JavaScript. But ANgular 2 is written in Typescript. 
> - Angular not a upgrade version of angular 1 but it is the totally rewritten.


## <b>3. Folder Structure</b>
- you can check out below link to angular folder structure
[Anguler folder Structure](https://angular.io/guide/file-structure)


## <b>4. SCSS annd PostCSS</b>

- ### scss:
    - scss stands for Sassy Cascaded Style Sheets. it  is the superset of CSS. SCSS is the more advanced version of CSS.

     - ### in css
    ```
    body{
        color: #ffffff;
        font: $ubuntu-font: 'Ubuntu', 'Arial', 'Helvetica', sans-serif;
        font-size: xx-large;
        padding: 2rem;
     }
    ```
    - ### in scss 

    ```
    $white: #ffffff;
    $ubuntu-font: $ubuntu-font: 'Ubuntu', 'Arial', 'Helvetica', sans-serif;

    body{
        color: $white;
        font: $ubuntu-font;
        font-size: xx-large;
        padding: 2rem;
    }
    ```

    - scss is pre-compiler of css.

