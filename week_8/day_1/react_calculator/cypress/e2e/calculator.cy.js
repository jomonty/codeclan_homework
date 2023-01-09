describe("Calculator", () => {
  beforeEach(() => {
    cy.visit("http://localhost:3000");
  })

  it('should have working number buttons', () => {
    cy.get('#number2').click();
    cy.get('.display').should('contain', '2');
    cy.get('#number4').click();
    cy.get('.display').should('contain', '24');
  })

  it('should update the display with the result of an operation', () => {
    cy.get('#number3').click();
    cy.get('#operator-multiply').click();
    cy.get('#number5').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', '15');
  })

  it('should be able to chain multiple operations together', () => {
    cy.get('#number3').click();
    cy.get('#operator-multiply').click();
    cy.get('#number8').click();
    cy.get('#operator-divide').click();
    cy.get('#number6').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', '4');
  })

  it('should correctly display a range of numbers', () => {
    // positive
    cy.get('#number3').click();
    cy.get('.display').should('contain', '3');
    // negative
    cy.get('#operator-subtract').click();
    cy.get('#number6').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', '-3');
    // decimals
    cy.get('#operator-divide').click();
    cy.get('#number2').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', '-1.5');
    // very large
    cy.get('#clear').click();
    cy.get('#clear').click();
    cy.get('#number1').click();
    cy.get('#number0').click();
    cy.get('#number0').click();
    cy.get('#number0').click();
    cy.get('#number0').click();
    cy.get('#number0').click();
    cy.get('#number0').click();
    cy.get('#number0').click();
    cy.get('.display').should('contain', '10000000');
  })

  it('should correctly display a divide by 0 error', () => {
    cy.get('#number8').click();
    cy.get('#operator-divide').click();
    cy.get('#number0').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', 'Error - divide by 0.');
  })
})