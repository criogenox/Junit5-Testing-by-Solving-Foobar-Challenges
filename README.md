[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<div align="center">
  <a align="center">
    <img src="https://user-images.githubusercontent.com/53323058/272986879-f514bd6a-1f0f-44c4-88df-1d2c74840cd3.png" alt="Logo" width="800">
  </a>
  <h3 align="center">Google Foobar</h3>
  <p align="center">
    Solved Tasks (personal attempt)
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About the project

<div align="justify">
Ok, It's not a project :smile:; but It was (and still) fun doing it. If you came here, already know what foobar is; If not, thanks for your visiting me :blush:. <br /> <br />

  Let's use ChatGPT shortcut for the explantion step: 

  
> **_Google's Foobar challenge is an invitation-only coding challenge that Google uses to identify and recruit talented programmers_** (being honest, they could offer a sort of internship if you're talent enough; not bad at all, anyway :muscle:)

> **_It typically appears as a pop-up message on a user's screen when they are searching for coding-related terms on Google_** (like a creepy surprise; I thought I was being hacked)

> **_Some people have reported receiving an invitation after searching for specific coding-related terms on Google; or have received an invitation through a referral_** (or looking for how to remove stain from carpet; whichever occurs first)

</div>

----
    $ ./mvnw clean install -Pfull
----

`$ ./mvnw clean install -Pfull`
<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

<div style="display: flex; flex-direction: row; align=center">
  <a href="https://www.java.com/en/">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/272988601-5d381490-9fe8-4e7c-9ea0-756f1fab6c84.png" alt="Logo" width="160" height="65"/>
  </a>
  <a href="https://junit.org/junit5/">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/272987918-7bde2fd7-76d6-40e7-ac78-239041b82942.png" alt="Logo" width="160" height="65"/>
  </a>
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- SUMMARY -->
## Background & Details

<div align="justify"> 
  <!-- <img align="right" src="https://user-images.githubusercontent.com/53323058/230650942-4c2e0ad4-2d52-46fe-aa67-8860c642e5f6.png" width="500"> -->
<img align="right" src="https://user-images.githubusercontent.com/53323058/230650942-4c2e0ad4-2d52-46fe-aa67-8860c642e5f6.png" width="500">

Both the theoretical and the real profiles (including worn ones) cannot be described by a linear function as in the case of wheels with a conical profile, therefore, the difference between the rolling radii of each wheel for different values of lateral displacement brings a nonlinear function ∆r. To linearize this function, the concept of equivalent conicity originally defined by the UIC 519 standard (EN 15302) is used, approximating the relationship between ∆r and the amplitude of the lateral displacement.

For a wheel with a conical profile, the equivalent conicity is simply the half-angle of the tread of the cone. For wheels with arbitrary profiles, the equivalent conicity is defined as the tangent of the angle of the cone of a purely conical profile whose lateral movement produces a kinematic oscillation with the same wavelength as the pair mounted with arbitrary profiles. This definition is only applicable in the analysis on straight paths and large radius curves (Rc ≥ 2500m).

In this way, the equivalent conicity is a parameter used to characterize the geometry of the wheel-rail contact and establishes the criterion for assessing the influence of the contact on the vehicle's driving stability on a straight track. 

<img align="right" width="500" src="https://user-images.githubusercontent.com/53323058/230651059-2a746e31-8ca0-42a1-9418-eb15def72d44.png">
  
The value of the wheel conicity provides quantitative information on the influence of the wheel-rail interaction on the quality of ride comfort and the dynamic stability of the rail vehicle.
  
High taper conicity (shortest wavelength at comparative constant speed):
  * Greater compensation of the centrifugal force on curved paths, reducing the risk of derailment.
  * Reduced driving comfort on a straight track due to the presence of greater lateral accelerations.
  
Low taper conicity (longer wavelength at comparative constant speed):
  * Increase in the frequency of occurrence of the flange hit during circulation in slight curves, causing excessive wear on the wheel profile.
  * Decreased lateral acceleration, increasing ride quality on straight paths.
  
The method proposed by the EN 15302 standard is based on the analysis of the kinetic movement of a pair mounted on a straight track or large radius curved paths. The determination of the equivalent conicity is performed by numerically integrating the function ∆r, representing the longitudinal distance traveled in terms of lateral displacement, x = f(y). From the latter, the wavelength λ is obtained for lateral displacements in the interval [1-7 mm] with increments ∆y ≤ 0.1mm, to finally determine the equivalent conicity by using the Klingel's formula for a conical profile whose kinematic movement presents the same wavelength.
  
<img align="right" width="500" src="https://user-images.githubusercontent.com/53323058/230651010-9eef1df9-c020-47aa-b1ca-87671a28effe.png">
 
The software capabilities focuses on the characterization of wheel-rail rigid contact through the aid of following specific calculations:

* Potential wheel-rail contact points detection by mean of rigid profiles penetration comparision.
* tan(γa) --> angle of the tangent to the point of contact between wheel and rail.
* ∆r --> rolling-radius difference function, at the predefined lateral amplitude interval. 
* tan(γc)=f(λ) --> Determination of the equivalent conicity for each movement wavelength of an (equivalente) conical profile, at a specific lateral displacement (wave amplitude).
  
The included parameters that influence the determination of the equivalent conicity are the geometry of the profiles, the gauge of the track, the inclination of the rail and the active gauge of the mounted pair. Other factors, not implemented up to the present time, that increase the complexity of the process calculation are the wear of the profiles and the deviations present in the track layout, such as the unevenness, gauge difference and alignment. 

From the processed conicity value, the stability of the vehicle can be evaluated depending on longitudinal running velocity, ensuring the generation of the required restoring forces when the formation goes through a open curve, increasing safety against derailment. Nevertheless, for real profiles and after a long period of use, the equivalent taper conicity can be reach values in a higher range due to excessive wear, and must be critically evaluated by a trained professional.       
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

- [x] Improve Potential Contact Points Detection 
- [x] Asymetric Cases Implementation
- [x] Stand-alone Unified Version
- [ ] Improve Error Events Handling
- [ ] Increse Profiles Data Base (Extending to APTA/ARR Standards)
- [ ] More & More Testing (Including Worn Cases)
- [ ] Implementation of Output Options (PDFBox library)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://user-images.githubusercontent.com/53323058/230575198-fa1acbf4-8f82-4d8e-b245-3979276bc240.png
[linkedin-url]: https://linkedin.com/in/
 
