import React from "react";
import { Navbar, Nav, Container, NavDropdown } from "react-bootstrap";
const Navigbar = () => {
  return (
    <>
      <Navbar bg="primary" variant="dark" expand="lg" sticky="top">
        <Container>
          <Navbar.Brand href="/home">TempShare</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="#">Home</Nav.Link>
              <Nav.Link href="#">Contact</Nav.Link>
              <Nav.Link href="/testing">(Admin Only) Testing</Nav.Link>
              <NavDropdown title="More" id="basic-nav-dropdown">
                <NavDropdown.Item href="#">
                  Nothing to see here yet
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
};

export default Navigbar;
