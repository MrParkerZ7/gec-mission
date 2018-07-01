#robot -d results product_test.robot
*** Settings ***
Documentation      Product-Test
Suite Teardown     Close All Browsers
Library            Selenium2Library

*** Variable ***
${list-page}       Available Product List
${add-page}        Add Product
${id-list-menu}    list
${id-add-menu}     add

*** Keywords ***
Start Up
    Open Browser                http://localhost:8080    chrome
    Title Should Be             Product Zone

Click and Check
    [Arguments]                 ${id}                    ${contains}
    Click Element               ${id}
    Wait Until Page Contains    ${contains}

Add Product
    [Arguments]                 ${name}                  ${price}        ${quantity}
    Input Text                  product-name             ${name}
    Input Text                  product-price            ${price}
    Input Text                  product-quantity         ${quantity}
    Click Button                btn-confirm
    Wait Until Page Contains    ${list-page}
    Page Should Contain         ${name}
    Page Should Contain         ${price}
    Page Should Contain         ${quantity}

*** Test Cases ***
Check Menu Bar
    Start Up
    Click and Check             ${id-add-menu}           ${add-page}
    Click and Check             ${id-list-menu}          ${list-page}
    [Teardown]                  Close Browser

Search Product
    Start Up
    Input Text                  search                   Pen
    Page Should Not Contain     Monitor
    [Teardown]                  Close Browser


Select Product to See Details
    Start Up
    Click Element               1
    Page Should Contain         Details Product :
    Page Should Contain         1
    [Teardown]                  Close Browser

Add Product Success
    Start Up
    Click and Check             ${id-add-menu}           ${add-page}
    Add Product                 Magic Box                999             1
    [Teardown]                  Close Browser

