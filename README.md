[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<div align="center">
  <a align="center">
    <img src="https://user-images.githubusercontent.com/53323058/273491246-3129bbb6-670a-49dc-a43c-87937bca67a2.png" alt="Logo" width="450">
  </a>
  <h3 align="center">Junit5 Usage applied to Solved Foobar Functions</h3>
  <p align="center">
     (a straightforward personal attempt)
  </p>
</div>

<!-- ABOUT THE REPO -->
## About the repo

<div align="justify">
Solving task on my own just for the enjoyment itself. It was (and still) fun doing it. Coding was made in one shot way, with a deadline and considering possible time-out errors. If you came here, already know what foobar is; If not, thanks for your visit :raised_hands:. <br /> <br />

  Let's use ChatGPT shortcut for the explantion step: 
  
> **_Google's Foobar challenge is an invitation-only coding challenge that Google uses to identify and recruit talented programmers_** (being honest, they probably could offer a sort of internship if you're talent enough; not bad at all, anyway :muscle:)

> **_It typically appears as a pop-up message on a user's screen when they are searching for coding-related terms on Google_** (like a creepy surprise; I thought I was being hacked)

> **_Some people have reported receiving an invitation after searching for specific coding-related terms on Google; or have received an invitation through a referral_** (or looking for how to remove stain from carpet; whichever occurs first)
          
just for the sake
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

<div style="display: flex; flex-direction: row; align=center">
  <a href="https://www.java.com/en/">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/273763700-87da1703-8aaa-473a-82a7-595478683383.png" alt="Logo" width="160" height="65"/>
  </a>
  <a href="https://junit.org/junit5/">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/273760886-5dd75127-437e-478e-9cae-3d28e3d89149.png" alt="Logo" width="160" height="65"/>
  </a>
  <a href="https://maven.apache.org/">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/230741096-33c1b8ab-1ec8-4364-b877-09aaa7df0fcd.png" alt="Logo" width="160" height="65"/>
  </a> 
  <a href="https://netbeans.apache.org/">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/273762946-9cd1d557-5ac2-4dd4-898f-9e0e369ecd72.png" alt="Logo" width="160" height="65"/>
  </a>
</div>

### Additional info

* If possible, done with plain readable java; no streams preferred used (let the brain does its job).
* Added more test cases (besides those originally given), including extreme ones to avoid long execution times.
* For a more in-depth understanding of the implemented code, as many comments as possible have been included.
* Each task constructor was renamed using suffixes (ex: solution1, solution2 and so forth) to include them in a single class.
* No intention of winning the code-of-the-year championship; It can be improved all what was done, be my guest.
 
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- SUMMARY -->
## Junit5 Implementation Details 

<div align="justify">

> **Annotations**
* `@Nested` (allowing to test several outer classes (challenges), actually inside the same main test class).
* `@ParameterizedTest` (addressing the run of same test passing several groups of parameters).
* `@CsvSource` (arguments source, as strings &/or ints).
* `@ValueSource` (arguments source, as strings or ints).
* `@MethodSource` (arguments source, as multidimensional arrays of int).
* `@TestInstance` (PER_CLASS; enabling one single instance of the test class reusable for all method).
* `@Order` (just for the sake of completeness, highly discouraged; switching the timeout test execution for the last)
* `@DisplayName` (on classes & methods).
* `@BeforeEach` (displaying on screen the timestamp & test info).
* `@Tag` (identifies each test class for display info purposes).

</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap (in no particular order)

- [x] `Square Supplies`
- [x] `Zombit Monitoring`
- [x] `Palindrome`
- [x] `Zombit Antidote`
- [x] `Please Pass The Coded Messages`
- [x] `Re-ID`
- [x] `Zombit Infection`

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://user-images.githubusercontent.com/53323058/230575198-fa1acbf4-8f82-4d8e-b245-3979276bc240.png
[linkedin-url]: https://linkedin.com/in/
 
